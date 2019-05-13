import ru.neoflex.meta.utils.Context
def session = Context.current.txSession
def entity = session.createQuery("from sse.HiveDataset where name = :name").setParameter("name", "ModelingPD_BAI_DictPortfolio").uniqueResult() 
entity.datasets.clear()
entity.workspace = session.createQuery("from sse.AnalyticWorkspace where name = :name").setParameter("name", "ModelingPD_BAI").uniqueResult()
entity.project = session.createQuery("from etl.Project where name = :name").setParameter("name", "BAI").uniqueResult()
Context.current.commit()
