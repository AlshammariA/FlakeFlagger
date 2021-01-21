@Test public void should_fail_when_some_field_values_differ_and_no_fields_are_ignored(){
  AssertionInfo info=someInfo();
  Jedi actual=new Jedi("Yoda","Green");
  Jedi other=new Jedi("Yoda","Blue");
  try {
    objects.assertIsEqualToIgnoringGivenFields(info,actual,other);
  }
 catch (  AssertionError err) {
    verify(failures).failure(info,shouldBeEqualToIgnoringGivenFields(actual,newArrayList("lightSaberColor"),newArrayList((Object)"Green"),newArrayList((Object)"Blue"),new ArrayList<String>()));
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
