@Test public void escapingAStringIsPossible() throws IOException {
  String string="Message: {{{hello \"\\\"world\\\"\"}}}";
  Hash helpers=$("hello",new Helper<String>(){
    @Override public CharSequence apply(    final String param,    final Options options) throws IOException {
      return "Hello " + param;
    }
  }
);
  shouldCompileTo(string,$,helpers,"Message: Hello \"world\"","template with an escaped String literal");
}
