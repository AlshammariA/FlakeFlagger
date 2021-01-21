@Test public void truthHash() throws IOException {
  Hash helpers=$("helper",new Helper<Object>(){
    @Override public CharSequence apply(    final Object context,    final Options options) throws IOException {
      assertEquals(true,options.hash("b"));
      return "ok";
    }
  }
);
  shouldCompileTo("{{helper . b=true}}",new Object(),helpers,"ok");
}
