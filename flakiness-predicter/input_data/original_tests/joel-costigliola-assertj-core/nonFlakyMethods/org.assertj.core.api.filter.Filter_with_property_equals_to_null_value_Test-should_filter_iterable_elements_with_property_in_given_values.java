@Test public void should_filter_iterable_elements_with_property_in_given_values(){
  rose.setTeam(null);
  durant.setTeam(null);
  Iterable<Player> filteredPlayers=filter(players).with("team").equalsTo(null).get();
  assertThat(filteredPlayers).containsOnly(rose,durant);
  assertThat(players).hasSize(4);
}
