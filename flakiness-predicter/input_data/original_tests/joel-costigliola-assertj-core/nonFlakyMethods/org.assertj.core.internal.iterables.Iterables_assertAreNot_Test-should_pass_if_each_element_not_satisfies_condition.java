@Test public void should_pass_if_each_element_not_satisfies_condition(){
  actual=newArrayList("Solo","Leia");
  iterables.assertAreNot(someInfo(),actual,jedi);
  verify(conditions).assertIsNotNull(jedi);
}
