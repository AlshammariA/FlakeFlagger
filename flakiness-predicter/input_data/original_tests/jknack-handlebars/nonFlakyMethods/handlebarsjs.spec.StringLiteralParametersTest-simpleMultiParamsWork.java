@Test public void simpleMultiParamsWork() throws IOException {
  String string="Message: {{goodbye cruel world}}";
  String hash="{cruel: cruel, world: world}";
  Hash helpers=$("goodbye",new Helper<String>(){
    @Override public CharSequence apply(    final String cruel,    final Options options) throws IOException {
      return "Goodbye " + cruel + " "+ options.get("world");
    }
  }
);
  shouldCompileTo(string,hash,helpers,"Message: Goodbye cruel world","regular helpers with multiple params");
}
