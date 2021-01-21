@Test public void passingInDataWorksWithHelpersInPartials() throws IOException {
  String string="{{>my_partial}}";
  Hash partials=$("my_partial","{{hello}}");
  Hash helpers=$("hello",new Helper<Object>(){
    @Override public CharSequence apply(    final Object context,    final Options options) throws IOException {
      return options.data("adjective") + " " + options.get("noun");
    }
  }
);
  Template template=compile(string,helpers,partials);
  String result=template.apply(Context.newContext($("noun","cat")).data("adjective","happy"));
  assertEquals("Data output by helper inside partial","happy cat",result);
}
