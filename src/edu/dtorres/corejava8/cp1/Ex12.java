package edu.dtorres.corejava8.cp1;

import java.io.IOException;
import java.io.Reader;

/**
 * The Java Development Kit includes a file src.zip with the source code of the
 * Java library. Unzip and, with your favorite text search tool, find usages of
 * the labeled break and continue sequences. Take one and rewrite it without a
 * labeled statement.
 * 
 * @author diego
 *
 */
public class Ex12 {
	/**
	 * The object used to synchronize operations on this stream. For efficiency,
	 * a character-stream object may use an object other than itself to protect
	 * critical sections. A subclass should therefore use the object in this
	 * field rather than <tt>this</tt> or a synchronized method.
	 */
	protected Object lock;

	/**
	 * I've found readLine from java.io.BufferedReader class. I've used VSCode
	 * to make a regex search in the unziped folder. Regex that I've used:
	 * break\s{1}[a-z]+;
	 * 
	 * @param args
	 */
	public static void main(String... args) {

	}

	private Reader in;
	/** If the next character is a line feed, skip it */
	private boolean skipLF = false;
	private char cb[];
	private int nChars, nextChar;
	private static final int INVALIDATED = -2;
	private static final int UNMARKED = -1;
	private int markedChar = UNMARKED;
	private int readAheadLimit = 0; /* Valid only when markedChar > 0 */
	private static int defaultExpectedLineLength = 80;

	/** Checks to make sure that the stream has not been closed */
	private void ensureOpen() throws IOException {
		if (in == null)
			throw new IOException("Stream closed");
	}

	/**
	 * Fills the input buffer, taking the mark into account if it is valid.
	 */
	private void fill() throws IOException {
		int dst;
		if (markedChar <= UNMARKED) {
			/* No mark */
			dst = 0;
		} else {
			/* Marked */
			int delta = nextChar - markedChar;
			if (delta >= readAheadLimit) {
				/* Gone past read-ahead limit: Invalidate mark */
				markedChar = INVALIDATED;
				readAheadLimit = 0;
				dst = 0;
			} else {
				if (readAheadLimit <= cb.length) {
					/* Shuffle in the current buffer */
					System.arraycopy(cb, markedChar, cb, 0, delta);
					markedChar = 0;
					dst = delta;
				} else {
					/* Reallocate buffer to accommodate read-ahead limit */
					char ncb[] = new char[readAheadLimit];
					System.arraycopy(cb, markedChar, ncb, 0, delta);
					cb = ncb;
					markedChar = 0;
					dst = delta;
				}
				nextChar = nChars = delta;
			}
		}

		int n;
		do {
			n = in.read(cb, dst, cb.length - dst);
		} while (n == 0);
		if (n > 0) {
			nChars = dst + n;
			nextChar = dst;
		}
	}

	String readLine(boolean ignoreLF) throws IOException {
		StringBuffer s = null;
		int startChar;

		synchronized (lock) {
			ensureOpen();
			boolean omitLF = ignoreLF || skipLF;

			for (;;) {
				if (nextChar >= nChars)

					fill();
				if (nextChar >= nChars) { /* EOF */
					if (s != null && s.length() > 0)
						return s.toString();
					else
						return null;
				}
				boolean eol = false;
				char c = 0;
				int i;

				/* Skip a leftover '\n', if necessary */
				if (omitLF && (cb[nextChar] == '\n'))
					nextChar++;
				skipLF = false;
				omitLF = false;

				for (i = nextChar; i < nChars; i++) {
					c = cb[i];
					if ((c == '\n') || (c == '\r')) {
						eol = true;
						// break charLoop;
						break;
					}
				}

				startChar = nextChar;
				nextChar = i;

				if (eol) {
					String str;
					if (s == null) {
						str = new String(cb, startChar, i - startChar);
					} else {
						s.append(cb, startChar, i - startChar);
						str = s.toString();
					}
					nextChar++;
					if (c == '\r') {
						skipLF = true;
					}
					return str;
				}

				if (s == null)
					s = new StringBuffer(defaultExpectedLineLength);
				s.append(cb, startChar, i - startChar);
			}
		}
	}
}
