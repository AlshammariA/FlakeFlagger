@Test public void partialPrecedingSelector() throws IOException {
  String string="Dudes: {{>dude}} {{another_dude}}";
  String dude="{{name}}";
  Object hash=$("name","Jeepers","another_dude","Creepers");
  shouldCompileToWithPartials(string,hash,$("dude",dude),"Dudes: Jeepers Creepers","Regular selectors can follow a partial");
}
