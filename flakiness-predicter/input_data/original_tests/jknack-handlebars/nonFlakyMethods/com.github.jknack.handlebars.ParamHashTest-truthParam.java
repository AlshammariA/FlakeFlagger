@Test public void truthParam() throws IOException {
  Hash helpers=$("helper",new Helper<Object>(){
    @Override public CharSequence apply(    final Object context,    final Options options) throws IOException {
      assertEquals(true,options.param(0));
      return "ok";
    }
  }
);
  shouldCompileTo("{{helper . true}}",new Object(),helpers,"ok");
}
