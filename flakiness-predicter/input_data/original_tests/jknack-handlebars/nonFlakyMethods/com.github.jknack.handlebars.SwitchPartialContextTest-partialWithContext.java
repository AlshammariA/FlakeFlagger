@Test public void partialWithContext() throws IOException {
  String partial="{{#this}}{{name}} {{/this}}";
  Hash hash=$("dudes",new Object[]{$("name","moe"),$("name","curly")});
  shouldCompileToWithPartials("Dudes: {{>dude dudes}}",hash,$("dude",partial),"Dudes: moe curly ");
}
