@Test public void dataIsInheritedDownstream() throws IOException {
  String string="{{#let foo=bar.baz}}{{@foo}}{{/let}}";
  Hash helpers=$("let",new Helper<Object>(){
    @Override public CharSequence apply(    final Object context,    final Options options) throws IOException {
      for (      Entry<String,Object> entry : options.hash.entrySet()) {
        options.data(entry.getKey(),entry.getValue());
      }
      return options.fn(context);
    }
  }
);
  Template template=compile(string,helpers);
  String result=template.apply($("bar",$("baz","hello world")));
  assertEquals("data variables are inherited downstream","hello world",result);
}
