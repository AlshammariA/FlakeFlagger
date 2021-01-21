@SuppressWarnings("unused") @Test public void functionReturningSafeStringsShouldnotBeEscaped() throws IOException {
  Object hash=new Object(){
    public Object getAwesome(){
      return new Handlebars.SafeString("&\"\\<>");
    }
  }
;
  shouldCompileTo("{{awesome}}",hash,"&\"\\<>","functions returning safestrings aren't escaped");
}
