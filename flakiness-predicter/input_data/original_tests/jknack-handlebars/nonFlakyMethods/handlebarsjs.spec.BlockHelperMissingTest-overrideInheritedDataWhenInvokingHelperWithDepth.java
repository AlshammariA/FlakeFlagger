@Test public void overrideInheritedDataWhenInvokingHelperWithDepth() throws IOException {
  String string="{{#hello}}{{world zomg}}{{/hello}}";
  Hash helpers=$("hello",new Helper<Object>(){
    @Override public CharSequence apply(    final Object context,    final Options options) throws IOException {
      return options.fn(Context.newContext($("exclaim","?","zomg","world")).data("adjective","sad"));
    }
  }
,"world",new Helper<Object>(){
    @Override public CharSequence apply(    final Object thing,    final Options options) throws IOException {
      return options.data("adjective") + " " + thing+ options.get("exclaim","");
    }
  }
);
  Template template=compile(string,helpers);
  String result=template.apply(Context.newContext($("exclaim",true,"zomg","planet")).data("adjective","happy").data("accessData","#win"));
  assertEquals("Overriden data output by helper","sad world?",result);
}
