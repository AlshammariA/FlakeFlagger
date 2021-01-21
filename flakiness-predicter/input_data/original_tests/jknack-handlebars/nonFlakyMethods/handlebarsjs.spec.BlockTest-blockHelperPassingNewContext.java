@Test public void blockHelperPassingNewContext() throws IOException {
  String string="{{#form yehuda}}<p>{{name}}</p>{{/form}}";
  String hash="{yehuda: {name: Yehuda}}";
  Hash helpers=$("form",new Helper<Object>(){
    @Override public CharSequence apply(    final Object context,    final Options options) throws IOException {
      return "<form>" + options.fn(context) + "</form>";
    }
  }
);
  shouldCompileTo(string,hash,helpers,"<form><p>Yehuda</p></form>","Context variable resolved");
}
