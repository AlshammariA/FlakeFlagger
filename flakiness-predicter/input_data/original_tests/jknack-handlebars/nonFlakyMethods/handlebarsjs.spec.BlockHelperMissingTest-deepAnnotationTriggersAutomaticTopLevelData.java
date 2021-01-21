@Test public void deepAnnotationTriggersAutomaticTopLevelData() throws IOException {
  String string="{{#let world=\"world\"}}{{#if foo}}{{#if foo}}Hello {{@world}}{{/if}}{{/if}}{{/let}}";
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
  String result=template.apply($("foo",true));
  assertEquals("Hello world",result);
}
