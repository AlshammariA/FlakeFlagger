/** 
 * Old implementations of OkHttp's response cache wrote header fields like ":status: 200 OK". This broke our cached response parser because it split on the first colon. This regression test exists to help us read these old bad cache entries. https://github.com/square/okhttp/issues/227
 */
@Test public void testGoldenCacheResponse() throws Exception {
  cache.close();
  server.enqueue(new MockResponse().clearHeaders().setResponseCode(HttpURLConnection.HTTP_NOT_MODIFIED));
  server.play();
  URL url=server.getUrl("/");
  String urlKey=Util.hash(url.toString());
  String entryMetadata="" + "" + url + "\n"+ "GET\n"+ "0\n"+ "HTTP/1.1 200 OK\n"+ "7\n"+ ":status: 200 OK\n"+ ":version: HTTP/1.1\n"+ "etag: foo\n"+ "content-length: 3\n"+ "OkHttp-Received-Millis: "+ System.currentTimeMillis()+ "\n"+ "X-Android-Response-Source: NETWORK 200\n"+ "OkHttp-Sent-Millis: "+ System.currentTimeMillis()+ "\n"+ "\n"+ "TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA\n"+ "1\n"+ "MIIBpDCCAQ2gAwIBAgIBATANBgkqhkiG9w0BAQsFADAYMRYwFAYDVQQDEw1qd2lsc29uLmxvY2FsMB4XDTEzMDgy"+ "OTA1MDE1OVoXDTEzMDgzMDA1MDE1OVowGDEWMBQGA1UEAxMNandpbHNvbi5sb2NhbDCBnzANBgkqhkiG9w0BAQEF"+ "AAOBjQAwgYkCgYEAlFW+rGo/YikCcRghOyKkJanmVmJSce/p2/jH1QvNIFKizZdh8AKNwojt3ywRWaDULA/RlCUc"+ "ltF3HGNsCyjQI/+Lf40x7JpxXF8oim1E6EtDoYtGWAseelawus3IQ13nmo6nWzfyCA55KhAWf4VipelEy8DjcuFK"+ "v6L0xwXnI0ECAwEAATANBgkqhkiG9w0BAQsFAAOBgQAuluNyPo1HksU3+Mr/PyRQIQS4BI7pRXN8mcejXmqyscdP"+ "7S6J21FBFeRR8/XNjVOp4HT9uSc2hrRtTEHEZCmpyoxixbnM706ikTmC7SN/GgM+SmcoJ1ipJcNcl8N0X6zym4dm"+ "yFfXKHu2PkTo7QFdpOJFvP3lIigcSZXozfmEDg==\n"+ "-1\n";
  String entryBody="abc";
  String journalBody="" + "libcore.io.DiskLruCache\n" + "1\n"+ "201105\n"+ "2\n"+ "\n"+ "CLEAN " + urlKey + " "+ entryMetadata.length()+ " "+ entryBody.length()+ "\n";
  writeFile(cache.getDirectory(),urlKey + ".0",entryMetadata);
  writeFile(cache.getDirectory(),urlKey + ".1",entryBody);
  writeFile(cache.getDirectory(),"journal",journalBody);
  cache=new HttpResponseCache(cache.getDirectory(),Integer.MAX_VALUE);
  client.setOkResponseCache(cache);
  HttpURLConnection connection=client.open(url);
  assertEquals(entryBody,readAscii(connection));
  assertEquals("3",connection.getHeaderField("Content-Length"));
  assertEquals("foo",connection.getHeaderField("etag"));
}
