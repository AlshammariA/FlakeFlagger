@Test public void itWorksWithSingleQoutes() throws IOException {
  String string="Message: {{{hello \"Alan\'s world\"}}}";
  Hash helpers=$("hello",new Helper<String>(){
    @Override public CharSequence apply(    final String param,    final Options options) throws IOException {
      return "Hello " + param;
    }
  }
);
  shouldCompileTo(string,$,helpers,"Message: Hello Alan's world","template with a ' mark");
}
