@Test public void should_create_error_message_with_single_field_difference(){
  factory=shouldBeEqualComparingOnlyGivenFields(new Jedi("Yoda","green"),newArrayList("lightSaberColor"),newArrayList((Object)"green"),newArrayList((Object)"blue"),newArrayList("lightSaberColor"));
  String message=factory.create(new TextDescription("Test"),new StandardRepresentation());
  assertThat(message).isEqualTo("[Test] \nExpecting value <\"blue\">" + " in field <\"lightSaberColor\">" + " but was <\"green\">"+ " in <Yoda the Jedi>");
}
