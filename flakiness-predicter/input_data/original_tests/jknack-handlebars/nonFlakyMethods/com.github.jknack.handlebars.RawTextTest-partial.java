@Test public void partial() throws IOException {
  assertEquals("hello {{>user}}!",compile("hello {{>user}}!",$(),$("user","{{user}}")).text());
}
