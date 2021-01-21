@Test public void falsyParam() throws IOException {
  Hash helpers=$("helper",new Helper<Object>(){
    @Override public CharSequence apply(    final Object context,    final Options options) throws IOException {
      assertEquals(false,options.param(0));
      return "ok";
    }
  }
);
  shouldCompileTo("{{helper . false}}",new Object(),helpers,"ok");
}
