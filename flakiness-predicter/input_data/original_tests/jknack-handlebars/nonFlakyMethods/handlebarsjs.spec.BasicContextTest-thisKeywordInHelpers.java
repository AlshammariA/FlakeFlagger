@Test public void thisKeywordInHelpers() throws IOException {
  Hash helpers=$("foo",new Helper<Object>(){
    @Override public CharSequence apply(    final Object value,    final Options options) throws IOException {
      return "bar " + value;
    }
  }
);
  String string="{{#goodbyes}}{{foo this}}{{/goodbyes}}";
  Object hash=$("goodbyes",new String[]{"goodbye","Goodbye","GOODBYE"});
  shouldCompileTo(string,hash,helpers,"bar goodbyebar Goodbyebar GOODBYE","This keyword in paths evaluates to current context");
  string="{{#hellos}}{{foo this/text}}{{/hellos}}";
  hash=$("hellos",new Object[]{$("text","hello"),$("text","Hello"),$("text","HELLO")});
  shouldCompileTo(string,hash,helpers,"bar hellobar Hellobar HELLO","This keyword evaluates in more complex paths");
}
