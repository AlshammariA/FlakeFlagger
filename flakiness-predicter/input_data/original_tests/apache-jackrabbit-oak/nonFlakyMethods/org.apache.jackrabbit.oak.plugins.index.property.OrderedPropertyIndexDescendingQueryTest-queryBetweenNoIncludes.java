@Test public void queryBetweenNoIncludes() throws Exception {
  setTravesalEnabled(false);
  final OrderDirection direction=OrderDirection.ASC;
  final String query="SELECT * FROM [nt:base] WHERE " + ORDERED_PROPERTY + "> $start AND "+ ORDERED_PROPERTY+ " < $end";
  Tree rTree=root.getTree("/");
  Tree test=rTree.addChild("test");
  Calendar start=midnightFirstJan2013();
  List<ValuePathTuple> nodes=addChildNodes(generateOrderedDates(NUMBER_OF_NODES,direction,start),test,direction,Type.DATE);
  root.commit();
  Calendar searchForCalendarStart=(Calendar)start.clone();
  searchForCalendarStart.add(Calendar.HOUR_OF_DAY,36);
  SimpleDateFormat sdf=new SimpleDateFormat(ISO_8601_2000);
  String searchForStart=sdf.format(searchForCalendarStart.getTime());
  Calendar endCalendar=Calendar.getInstance();
  endCalendar.setTime(sdf.parse(nodes.get(nodes.size() - 1).getValue()));
  endCalendar.add(Calendar.HOUR_OF_DAY,-36);
  String searchForEnd=sdf.format(endCalendar.getTime());
  Map<String,PropertyValue> filter=ImmutableMap.of("start",PropertyValues.newDate(searchForStart),"end",PropertyValues.newDate(searchForEnd));
  Iterator<? extends ResultRow> results=executeQuery(query,SQL2,filter).getRows().iterator();
  Collections.sort(nodes,Collections.reverseOrder());
  Iterator<ValuePathTuple> filtered=Iterables.filter(nodes,new ValuePathTuple.BetweenPredicate(searchForStart,searchForEnd,false,false)).iterator();
  if (LOG.isDebugEnabled()) {
    LOG.debug("--- added nodes");
    for (    ValuePathTuple n : nodes) {
      LOG.debug("{}",n);
    }
    LOG.debug("--- expected list");
    while (filtered.hasNext()) {
      LOG.debug("{}",filtered.next());
    }
    filtered=Iterables.filter(nodes,new ValuePathTuple.BetweenPredicate(searchForStart,searchForEnd,false,false)).iterator();
  }
  assertRightOrder(Lists.newArrayList(filtered),results);
  assertFalse("We should have looped throuhg all the results",results.hasNext());
  setTravesalEnabled(true);
}
