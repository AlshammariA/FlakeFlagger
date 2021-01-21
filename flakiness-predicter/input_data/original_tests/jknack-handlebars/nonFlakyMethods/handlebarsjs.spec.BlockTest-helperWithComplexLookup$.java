@Test public void helperWithComplexLookup$() throws IOException {
  String string="{{#goodbyes}}{{{link ../prefix}}}{{/goodbyes}}";
  Object hash=$("prefix","/root","goodbyes",new Object[]{$("text","Goodbye","url","goodbye")});
  Hash helpers=$("link",new Helper<Object>(){
    @Override public CharSequence apply(    final Object prefix,    final Options options) throws IOException {
      Object url=options.context.get("url");
      Object text=options.context.get("text");
      return "<a href='" + prefix + "/"+ url+ "'>"+ text+ "</a>";
    }
  }
);
  shouldCompileTo(string,hash,helpers,"<a href='/root/goodbye'>Goodbye</a>");
}
