@Test public void should_filter_iterable_elements_satisfying_condition(){
  Iterable<Player> playersHavinMvpStats=filter(players).having(mvpStats).get();
  assertThat(playersHavinMvpStats).containsOnly(rose,james);
  assertThat(players).hasSize(4);
}
