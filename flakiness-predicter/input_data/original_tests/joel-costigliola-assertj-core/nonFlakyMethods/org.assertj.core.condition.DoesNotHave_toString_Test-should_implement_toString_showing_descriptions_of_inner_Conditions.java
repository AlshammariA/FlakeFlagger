@Test public void should_implement_toString_showing_descriptions_of_inner_Conditions(){
  String expected="does not have :<JediPower>";
  assertEquals(expected,doesNotHave.toString());
}
