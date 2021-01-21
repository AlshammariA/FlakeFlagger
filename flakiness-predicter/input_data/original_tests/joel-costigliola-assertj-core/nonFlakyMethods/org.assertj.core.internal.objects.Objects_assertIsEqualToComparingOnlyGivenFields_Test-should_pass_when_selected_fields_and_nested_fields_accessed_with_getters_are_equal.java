@Test public void should_pass_when_selected_fields_and_nested_fields_accessed_with_getters_are_equal(){
  Player rose=new Player(new Name("Derrick","Rose"),"Chicago Bulls");
  Player jalen=new Player(new Name("Derrick","Coleman"),"Chicago Bulls");
  objects.assertIsEqualToComparingOnlyGivenFields(someInfo(),rose,jalen,"team","name.first");
}
