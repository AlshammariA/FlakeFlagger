@Test public void renderingFunctionPartial() throws IOException {
  String string="Dudes: {{#dudes}}{{> dude}}{{/dudes}}";
  String partial="{{name}} ({{url}}) ";
  Object hash=$("dudes",new Object[]{$("name","Yehuda","url","http://yehuda"),$("name","Alan","url","http://alan")});
  shouldCompileToWithPartials(string,hash,$("dude",partial),"Dudes: Yehuda (http://yehuda) Alan (http://alan) ","Function partials output based in VM.");
}
