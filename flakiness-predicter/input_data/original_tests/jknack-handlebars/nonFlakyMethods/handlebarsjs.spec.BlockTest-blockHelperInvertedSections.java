@Test public void blockHelperInvertedSections() throws Exception {
  String string="{{#list people}}{{name}}{{^}}<em>Nobody's here</em>{{/list}}";
  Hash helpers=$("list",new Helper<List<Object>>(){
    @Override public CharSequence apply(    final List<Object> context,    final Options options) throws IOException {
      if (context.size() > 0) {
        String out="<ul>";
        for (        Object element : context) {
          out+="<li>";
          out+=options.fn(element);
          out+="</li>";
        }
        out+="</ul>";
        return out;
      }
 else {
        return "<p>" + options.inverse(this) + "</p>";
      }
    }
  }
);
  Object hash=$("people",new Object[]{$("name","Alan"),$("name","Yehuda")});
  Object empty=$("people",new Object[0]);
  Object rootMessage=$("people",new Object[0],"message","Nobody's here");
  String messageString="{{#list people}}Hello{{^}}{{message}}{{/list}}";
  shouldCompileTo(string,hash,helpers,"<ul><li>Alan</li><li>Yehuda</li></ul>","an inverse wrapper is passed in as a new context");
  shouldCompileTo(string,empty,helpers,"<p><em>Nobody's here</em></p>","an inverse wrapper can be optionally called");
  shouldCompileTo(messageString,rootMessage,helpers,"<p>Nobody&#x27;s here</p>","the context of an inverse is the parent of the block");
}
