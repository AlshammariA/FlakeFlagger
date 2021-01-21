@Test public void testURI(){
  doTest("google.com","http://google.com",null);
  doTest("123.com","http://123.com",null);
  doTest("http://google.com","http://google.com",null);
  doTest("https://google.com","https://google.com",null);
  doTest("google.com:443","http://google.com:443",null);
  doTest("https://www.google.com/calendar/hosted/google.com/embed?mode=AGENDA&force_login=true&src=google.com_726f6f6d5f6265707075@resource.calendar.google.com","https://www.google.com/calendar/hosted/google.com/embed?mode=AGENDA&force_login=true&src=google.com_726f6f6d5f6265707075@resource.calendar.google.com",null);
  doTest("otpauth://remoteaccess?devaddr=00%a1b2%c3d4&devname=foo&key=bar","otpauth://remoteaccess?devaddr=00%a1b2%c3d4&devname=foo&key=bar",null);
  doTest("s3://amazon.com:8123","s3://amazon.com:8123",null);
  doTest("HTTP://R.BEETAGG.COM/?12345","HTTP://R.BEETAGG.COM/?12345",null);
}
