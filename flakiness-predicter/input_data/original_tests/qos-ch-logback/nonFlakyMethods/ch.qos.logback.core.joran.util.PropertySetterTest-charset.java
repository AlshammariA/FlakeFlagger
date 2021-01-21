@Test public void charset(){
  setter.setProperty("charset","UTF-8");
  assertEquals(Charset.forName("UTF-8"),house.getCharset());
  house.setCharset(null);
  setter.setProperty("charset","UTF");
  assertNull(house.getCharset());
  StatusChecker checker=new StatusChecker(context);
  checker.containsException(UnsupportedCharsetException.class);
}
