@Test public void blockHelperShouldHaveContextInThis() throws IOException {
  String string="<ul>{{#people}}<li>{{#link}}{{name}}{{/link}}</li>{{/people}}</ul>";
  Object hash=$("people",new Object[]{$("name","Alan","id",1),$("name","Yehuda","id",2)});
  Hash helpers=$("link",new Helper<Object>(){
    @Override public CharSequence apply(    final Object context,    final Options options) throws IOException {
      return "<a href=\"/people/" + options.get("id") + "\">"+ options.fn(this)+ "</a>";
    }
  }
);
  shouldCompileTo(string,hash,helpers,"<ul><li><a href=\"/people/1\">Alan</a></li><li><a href=\"/people/2\">Yehuda</a></li></ul>");
}
