@Test public void testCodingFromFileSmaller() throws Exception {
  ByteArrayOutputStream baos=new ByteArrayOutputStream();
  WritableByteChannel channel=newChannel(baos);
  HttpParams params=new BasicHttpParams();
  SessionOutputBuffer outbuf=new SessionOutputBufferImpl(1024,128,params);
  HttpTransportMetricsImpl metrics=new HttpTransportMetricsImpl();
  LengthDelimitedEncoder encoder=new LengthDelimitedEncoder(channel,outbuf,metrics,16);
  File tmpFile=File.createTempFile("testFile",".txt");
  FileOutputStream fout=new FileOutputStream(tmpFile);
  OutputStreamWriter wrtout=new OutputStreamWriter(fout);
  wrtout.write("stuff;");
  wrtout.write("more stuff;");
  wrtout.flush();
  wrtout.close();
  FileChannel fchannel=new FileInputStream(tmpFile).getChannel();
  encoder.transfer(fchannel,0,20);
  String s=baos.toString("US-ASCII");
  Assert.assertTrue(encoder.isCompleted());
  Assert.assertEquals("stuff;more stuff",s);
  fchannel.close();
  deleteWithCheck(tmpFile);
}
