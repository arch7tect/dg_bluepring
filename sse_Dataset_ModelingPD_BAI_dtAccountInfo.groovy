import ru.neoflex.meta.utils.Context
def session = Context.current.txSession
def entity = session.createQuery("from sse.Dataset where name = :name").setParameter("name", "ModelingPD_BAI_dtAccountInfo").uniqueResult() 
entity.datasets.clear()
entity.workspace = session.createQuery("from sse.AnalyticWorkspace where name = :name").setParameter("name", "ModelingPD_BAI").uniqueResult()
entity.project = session.createQuery("from etl.Project where name = :name").setParameter("name", "BAI").uniqueResult()
entity.datasets.add(session.createQuery("from sse.Dataset where name = :name").setParameter("name", "ModelingPD_BAI_dtAccounts").uniqueResult())
entity.datasets.add(session.createQuery("from sse.Dataset where name = :name").setParameter("name", "ModelingPD_BAI_dictEconomicSectors").uniqueResult())
Context.current.commit()
