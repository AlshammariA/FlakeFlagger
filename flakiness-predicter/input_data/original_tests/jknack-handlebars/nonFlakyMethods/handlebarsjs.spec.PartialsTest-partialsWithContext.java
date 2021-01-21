@Test public void partialsWithContext() throws IOException {
  String string="Dudes: {{>dude dudes}}";
  String partial="{{#this}}{{name}} ({{url}}) {{/this}}";
  Object hash=$("dudes",new Object[]{$("name","Yehuda","url","http://yehuda"),$("name","Alan","url","http://alan")});
  shouldCompileToWithPartials(string,hash,$("dude",partial),"Dudes: Yehuda (http://yehuda) Alan (http://alan) ","Partials can be passed a context");
}
