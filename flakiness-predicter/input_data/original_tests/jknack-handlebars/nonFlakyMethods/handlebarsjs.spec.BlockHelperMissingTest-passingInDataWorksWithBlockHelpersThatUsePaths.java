@Test public void passingInDataWorksWithBlockHelpersThatUsePaths() throws IOException {
  String string="{{#hello}}{{world ../zomg}}{{/hello}}";
  Hash helpers=$("hello",new Helper<Object>(){
    @Override public CharSequence apply(    final Object context,    final Options options) throws IOException {
      return options.fn($("exclaim","?"));
    }
  }
,"world",new Helper<Object>(){
    @Override public CharSequence apply(    final Object thing,    final Options options) throws IOException {
      return options.data("adjective") + " " + thing+ options.get("exclaim","");
    }
  }
);
  Template template=compile(string,helpers);
  String result=template.apply(Context.newContext($("exclaim",true,"zomg","world")).data("adjective","happy"));
  assertEquals("happy world?",result);
}
