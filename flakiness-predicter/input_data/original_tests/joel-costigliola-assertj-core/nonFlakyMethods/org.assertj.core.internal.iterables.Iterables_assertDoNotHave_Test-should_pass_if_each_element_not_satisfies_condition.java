@Test public void should_pass_if_each_element_not_satisfies_condition(){
  actual=newArrayList("Solo","Leia");
  iterables.assertDoNotHave(someInfo(),actual,jediPower);
  verify(conditions).assertIsNotNull(jediPower);
}
