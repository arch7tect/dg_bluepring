import ru.neoflex.meta.utils.Context
def session = Context.current.txSession
def entity = session.createQuery("from sse.Notebook where name = :name").setParameter("name", "ModelingPD_Modelling").uniqueResult() 
entity.datasets.clear()
entity.workspace = session.createQuery("from sse.AnalyticWorkspace where name = :name").setParameter("name", "ModelingPD").uniqueResult()
entity.project = session.createQuery("from etl.Project where name = :name").setParameter("name", "blueprint_git").uniqueResult()
entity.datasets.add(session.createQuery("from sse.Dataset where name = :name").setParameter("name", "ModelingPD_dtAccounts").uniqueResult())
entity.datasets.add(session.createQuery("from sse.Dataset where name = :name").setParameter("name", "ModelingPD_dtForbearance").uniqueResult())
entity.datasets.add(session.createQuery("from sse.Dataset where name = :name").setParameter("name", "ModelingPD_dtPDModel").uniqueResult())
entity.datasets.add(session.createQuery("from sse.Dataset where name = :name").setParameter("name", "ModelingPD_adWriteOffContracts").uniqueResult())
entity.datasets.add(session.createQuery("from sse.Dataset where name = :name").setParameter("name", "ModelingPD_dtDictPortfolio").uniqueResult())
entity.paragraphs.find {it.name == "ModelingPD_BAI_Modelling_2019-03-11T11:44:24.149"}.body.linkNotebook = session.createQuery("from sse.Notebook where name = :name").setParameter("name", "ModelingPD_FunctionLibrary").uniqueResult()
Context.current.commit()
