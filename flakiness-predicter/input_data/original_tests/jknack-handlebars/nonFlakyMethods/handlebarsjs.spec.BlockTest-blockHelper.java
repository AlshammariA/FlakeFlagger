@Test public void blockHelper() throws IOException {
  String string="{{#goodbyes}}{{text}}! {{/goodbyes}}cruel {{world}}!";
  String hash="{world: world}";
  Hash helpers=$("goodbyes",new Helper<Object>(){
    @Override public CharSequence apply(    final Object context,    final Options options) throws IOException {
      return options.fn($("text","GOODBYE"));
    }
  }
);
  shouldCompileTo(string,hash,helpers,"GOODBYE! cruel world!","Block helper executed");
}
