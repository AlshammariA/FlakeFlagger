@Test public void shouldReturnEmptyCollectionWhenAResourceIsNotContainedInAnyGroup(){
  assertTrue(victim.getGroupNamesContainingResource("/resourceMissingFromModel.js").isEmpty());
}
