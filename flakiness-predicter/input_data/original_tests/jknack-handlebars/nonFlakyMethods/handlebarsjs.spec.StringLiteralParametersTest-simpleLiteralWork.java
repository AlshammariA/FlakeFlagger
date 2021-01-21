@Test public void simpleLiteralWork() throws IOException {
  String string="Message: {{hello \"world\" 12 true false}}";
  Hash helpers=$("hello",new Helper<Object>(){
    @Override public CharSequence apply(    final Object context,    final Options options) throws IOException {
      return "Hello " + context + " "+ options.param(0)+ " times: "+ options.param(1)+ " "+ options.param(2);
    }
  }
);
  shouldCompileTo(string,$,helpers,"Message: Hello world 12 times: true false","template with a simple String literal");
}
