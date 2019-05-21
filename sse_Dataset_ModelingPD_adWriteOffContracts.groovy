import ru.neoflex.meta.utils.Context
def session = Context.current.txSession
def entity = session.createQuery("from sse.Dataset where name = :name").setParameter("name", "ModelingPD_adWriteOffContracts").uniqueResult() 
entity.datasets.clear()
entity.workspace = session.createQuery("from sse.AnalyticWorkspace where name = :name").setParameter("name", "ModelingPD").uniqueResult()
entity.project = session.createQuery("from etl.Project where name = :name").setParameter("name", "blueprint_git").uniqueResult()
entity.datasets.add(session.createQuery("from sse.HiveDataset where name = :name").setParameter("name", "ModelingPD_WriteOff").uniqueResult())
Context.current.commit()
