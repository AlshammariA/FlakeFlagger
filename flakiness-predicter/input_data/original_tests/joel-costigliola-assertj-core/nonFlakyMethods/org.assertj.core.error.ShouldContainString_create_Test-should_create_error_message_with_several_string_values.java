@Test public void should_create_error_message_with_several_string_values(){
  factory=shouldContain("Yoda, Luke",array("Luke","Vador","Solo"),newSet("Vador","Solo"));
  String message=factory.create(new TextDescription("Test"),new StandardRepresentation());
  assertEquals("[Test] \nExpecting:\n <\"Yoda, Luke\">\nto contain:\n <[\"Luke\", \"Vador\", \"Solo\"]>\nbut could not find:\n <[\"Vador\", \"Solo\"]>\n ",message);
}
