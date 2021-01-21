@Test public void blockHelperPassingComplexContextPath() throws IOException {
  String string="{{#form yehuda/cat}}<p>{{name}}</p>{{/form}}";
  String hash="{yehuda: {name: Yehuda, cat: {name: Harold}}}";
  Hash helpers=$("form",new Helper<Object>(){
    @Override public CharSequence apply(    final Object context,    final Options options) throws IOException {
      return "<form>" + options.fn(context) + "</form>";
    }
  }
);
  shouldCompileTo(string,hash,helpers,"<form><p>Harold</p></form>","Complex path variable resolved");
}
