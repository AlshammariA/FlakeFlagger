/** 
 * test the range query in case of '>=' condition
 * @throws CommitFailedException
 * @throws ParseException
 */
@Test public void queryGreaterEqualThan() throws CommitFailedException, ParseException {
  setTravesalEnabled(false);
  final OrderDirection direction=OrderDirection.ASC;
  final String query="SELECT * FROM [nt:base] AS n WHERE n.%s >= $%s";
  Tree rTree=root.getTree("/");
  Tree test=rTree.addChild("test");
  Calendar start=midnightFirstJan2013();
  List<ValuePathTuple> nodes=addChildNodes(generateOrderedDates(NUMBER_OF_NODES,direction,start),test,direction,Type.DATE);
  root.commit();
  Calendar searchForCalendar=(Calendar)start.clone();
  searchForCalendar.add(Calendar.HOUR_OF_DAY,36);
  String searchFor=new SimpleDateFormat(ISO_8601_2000).format(searchForCalendar.getTime());
  Map<String,PropertyValue> filter=ImmutableMap.of(ORDERED_PROPERTY,PropertyValues.newDate(searchFor));
  Iterator<? extends ResultRow> results=executeQuery(String.format(query,ORDERED_PROPERTY,ORDERED_PROPERTY),SQL2,filter).getRows().iterator();
  Iterator<ValuePathTuple> filtered=Iterables.filter(nodes,new ValuePathTuple.GreaterThanPredicate(searchFor,true)).iterator();
  assertRightOrder(Lists.newArrayList(filtered),results);
  assertFalse("We should have looped throuhg all the results",results.hasNext());
  setTravesalEnabled(true);
}
