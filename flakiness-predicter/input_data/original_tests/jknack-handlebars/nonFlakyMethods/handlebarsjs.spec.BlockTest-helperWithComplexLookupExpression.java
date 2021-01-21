@Test public void helperWithComplexLookupExpression() throws IOException {
  String string="{{#goodbyes}}{{../name}}{{/goodbyes}}";
  String hash="{name: Alan}";
  Hash helpers=$("goodbyes",new Helper<Object>(){
    @Override public CharSequence apply(    final Object context,    final Options options) throws IOException {
      String out="";
      String[] byes={"Goodbye","goodbye","GOODBYE"};
      for (      String bye : byes) {
        out+=bye + " " + options.fn(this)+ "! ";
      }
      return out;
    }
  }
);
  shouldCompileTo(string,hash,helpers,"Goodbye Alan! goodbye Alan! GOODBYE Alan! ");
}
