@Test public void partialInPartial() throws IOException {
  String string="Dudes: {{#dudes}}{{>dude}}{{/dudes}}";
  String dude="{{name}} {{> url}} ";
  String url="<a href='{{url}}'>{{url}}</a>";
  Object hash=$("dudes",new Object[]{$("name","Yehuda","url","http://yehuda"),$("name","Alan","url","http://alan")});
  shouldCompileToWithPartials(string,hash,$("dude",dude,"url",url),"Dudes: Yehuda <a href='http://yehuda'>http://yehuda</a> Alan <a href='http://alan'>http://alan</a> ","Partials are rendered inside of other partials");
}
