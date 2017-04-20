package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class DatabaseReader
{
	private static DatabaseReader instance;

	StringBuffer buf;
	String[] result = null;
	boolean found = false;

	InputStream is;
	BufferedReader reader;
	InputStream is2;
	InputStream is3;

	private DatabaseReader()
	{

	}

	//implementation of a background thread
	// public void start(String hashAlgo, String hash) throws Exception
	// {
	// result = null;
	// reader = null;
	// found = false;
	// buf = new StringBuffer();
	// is = getClass().getResourceAsStream("/ressources/vx.txt");
	// is2 = getClass().getResourceAsStream("/ressources/main.mdb");
	// is3 = getClass().getResourceAsStream("/ressources/main.hdb");
	//
	// Service<Void> service = new Service<Void>()
	// {
	// @Override
	// protected Task<Void> createTask()
	// {
	// return new Task<Void>()
	// {
	// @Override
	// protected Void call() throws Exception
	// {
	// System.out.println("searching for value");
	// // Background work
	// final CountDownLatch latch = new CountDownLatch(1);
	// Platform.runLater(new Runnable()
	// {
	// @Override
	// public void run()
	// {
	// try
	// {
	// String line;
	// reader = new BufferedReader(new InputStreamReader(is));
	// if (is != null)
	// {
	// System.out.println("searching for value in first file");
	// while ((line = reader.readLine()) != null)
	// {
	// try
	// {
	// if (line.trim().length() != 0)
	// {
	// String[] arrOfStr = line.trim().split(",", -2);
	// if (hashAlgo.equalsIgnoreCase("md5"))
	// {
	// String hashValue = arrOfStr[4].trim();
	// if (hash.equalsIgnoreCase(hashValue))
	// {
	// result = new String[]
	// { arrOfStr[3], arrOfStr[4], arrOfStr[5], arrOfStr[6] };
	// System.out.println(arrOfStr[3]);
	//// Controller.updateResult(result);
	//
	// found = true;
	// break;
	// }
	// } else if (hashAlgo.equalsIgnoreCase("sha-1"))
	// {
	// String hashValue = arrOfStr[5].trim();
	// if (hash.equalsIgnoreCase(hashValue))
	// {
	// result = new String[]
	// { arrOfStr[3], arrOfStr[4], arrOfStr[5], arrOfStr[6] };
	// System.out.println(arrOfStr[3]);
	// found = true;
	// break;
	// }
	// } else if (hashAlgo.equalsIgnoreCase("sha-256"))
	// {
	// String hashValue = arrOfStr[6].trim();
	// if (hash.equalsIgnoreCase(hashValue))
	// {
	// result = new String[]
	// { arrOfStr[3], arrOfStr[4], arrOfStr[5], arrOfStr[6] };
	// System.out.println(arrOfStr[3]);
	// found = true;
	// break;
	// }
	// }
	// }
	// } catch (Exception e)
	// {
	// e.printStackTrace();
	// }
	// }
	// }
	// if (!found )
	// {
	// if (is2 != null)
	// {
	// System.out.println("searching for value in second file");
	// reader = new BufferedReader(new InputStreamReader(is2));
	// if (hashAlgo.equalsIgnoreCase("md5"))
	// {
	// while ((line = reader.readLine()) != null)
	// {
	// try
	// {
	// if (line.trim().length() != 0)
	// {
	// String[] arrOfStr = line.trim().split(":", -2);
	//
	// String hashValue = arrOfStr[1].trim();
	// if (hash.equalsIgnoreCase(hashValue))
	// {
	// result = new String[]
	// { arrOfStr[2], arrOfStr[0] };
	// System.out.println(arrOfStr[2]);
	// found = true;
	// break;
	// }
	// }
	// } catch (Exception e)
	// {
	// e.printStackTrace();
	// }
	// }
	// }
	// }
	// }
	// if (!found )
	// {
	// if (is3 != null)
	// {
	// System.out.println("searching for value in third file");
	// reader = new BufferedReader(new InputStreamReader(is3));
	// if (hashAlgo.equalsIgnoreCase("md5"))
	// {
	// while ((line = reader.readLine()) != null)
	// {
	// try
	// {
	// if (line.trim().length() != 0)
	// {
	// String[] arrOfStr = line.trim().split(":", -2);
	//
	// String hashValue = arrOfStr[0].trim();
	// if (hash.equalsIgnoreCase(hashValue))
	// {
	// result = new String[]
	// { arrOfStr[2], arrOfStr[0] };
	// System.out.println(arrOfStr[2]);
	// found = true;
	// break;
	// }
	// }
	// } catch (Exception e)
	// {
	// e.printStackTrace();
	// }
	// }
	// }
	// }
	// }
	// } catch (IOException e)
	// {
	// e.printStackTrace();
	// } finally
	// {
	// try
	// {
	// is.close();
	// } catch (Throwable ignore)
	// {
	// }
	// latch.countDown();
	// }
	// }
	//
	//
	// });
	// latch.await();
	// // Keep with the background work
	// return null;
	// }
	// };
	// }
	// };
	// service.start();
	// }

	public String[] start(String hashAlgo, String hash) throws Exception
	{
		result = null;
		reader = null;
		found = false;
		buf = new StringBuffer();
		//load the 3 file containning the virus signatures
		is = getClass().getResourceAsStream("/ressources/vx.txt");
		is2 = getClass().getResourceAsStream("/ressources/main.mdb");
		is3 = getClass().getResourceAsStream("/ressources/main.hdb");

		try
		{
			String line;
			reader = new BufferedReader(new InputStreamReader(is));
			//read the first file vx.txt
			if (is != null)
			{
				System.out.println("searching for value in first file");
				while ((line = reader.readLine()) != null)
				{
					if (line.trim().length() != 0)
					{
						String[] arrOfStr = line.trim().split(",", -2);
						if (hashAlgo.equalsIgnoreCase("md5"))
						{
							String hashValue = arrOfStr[4].trim();
							if (hash.equalsIgnoreCase(hashValue))
							{
								result = new String[]
								{ arrOfStr[3], arrOfStr[4], arrOfStr[5], arrOfStr[6] };
								System.out.println(arrOfStr[3]);
								found = true;
								break;
							}
						} else if (hashAlgo.equalsIgnoreCase("sha-1"))
						{
							String hashValue = arrOfStr[5].trim();
							if (hash.equalsIgnoreCase(hashValue))
							{
								result = new String[]
								{ arrOfStr[3], arrOfStr[4], arrOfStr[5], arrOfStr[6] };
								System.out.println(arrOfStr[3]);
								found = true;
								break;
							}
						} else if (hashAlgo.equalsIgnoreCase("sha-256"))
						{
							String hashValue = arrOfStr[6].trim();
							if (hash.equalsIgnoreCase(hashValue))
							{
								result = new String[]
								{ arrOfStr[3], arrOfStr[4], arrOfStr[5], arrOfStr[6] };
								System.out.println(arrOfStr[3]);
								found = true;
								break;
							}
						}
					}

				}
			}
			//read the second file take from Clamav database if the previos could not provide the hash value
			if (!found)
			{
				if (is2 != null)
				{
					System.out.println("searching for value in second file");
					reader = new BufferedReader(new InputStreamReader(is2));
					if (hashAlgo.equalsIgnoreCase("md5"))
					{
						while ((line = reader.readLine()) != null)
						{
							if (line.trim().length() != 0)
							{
								String[] arrOfStr = line.trim().split(":", -2);

								String hashValue = arrOfStr[1].trim();
								if (hash.equalsIgnoreCase(hashValue))
								{
									result = new String[]
									{ arrOfStr[2], arrOfStr[0] };
									System.out.println(arrOfStr[2]);
									found = true;
									break;
								}
							}

						}
					}
				}
			}
			//read the third file take from Clamav database if the previos search failled
			if (!found)
			{
				if (is3 != null)
				{
					System.out.println("searching for value in third file");
					reader = new BufferedReader(new InputStreamReader(is3));
					if (hashAlgo.equalsIgnoreCase("md5"))
					{
						while ((line = reader.readLine()) != null)
						{
							if (line.trim().length() != 0)
							{
								String[] arrOfStr = line.trim().split(":", -2);

								String hashValue = arrOfStr[0].trim();
								if (hash.equalsIgnoreCase(hashValue))
								{
									result = new String[]
									{ arrOfStr[2], arrOfStr[0] };
									System.out.println(arrOfStr[2]);
									found = true;
									break;
								}
							}

						}
					}
				}
			}
		} catch (IOException e)
		{
			e.printStackTrace();
		} finally
		{
			try
			{
				is.close();
			} catch (Throwable ignore)
			{
			}
		}
		return result;

	}

	/**
	 * 
	 * @lastChanged: theophane
	 */
	public static DatabaseReader getInstance()
	{
		if (DatabaseReader.instance == null)
		{
			DatabaseReader.instance = new DatabaseReader();
		}
		return instance;
	}

}
