import ru.neoflex.meta.utils.Context
def session = Context.current.txSession
def entity = session.createQuery("from sse.Notebook where name = :name").setParameter("name", "ModelingPD_BAI_Modelling").uniqueResult() 
entity.datasets.clear()
entity.workspace = session.createQuery("from sse.AnalyticWorkspace where name = :name").setParameter("name", "ModelingPD").uniqueResult()
entity.project = session.createQuery("from etl.Project where name = :name").setParameter("name", "blueprint_git").uniqueResult()
entity.datasets.add(session.createQuery("from sse.Dataset where name = :name").setParameter("name", "ModelingPD_BAI_dtDictPortfolio").uniqueResult())
entity.datasets.add(session.createQuery("from sse.Dataset where name = :name").setParameter("name", "ModelingPD_BAI_adWriteOffContracts").uniqueResult())
entity.datasets.add(session.createQuery("from sse.Dataset where name = :name").setParameter("name", "ModelingPD_BAI_dtAccounts").uniqueResult())
entity.datasets.add(session.createQuery("from sse.Dataset where name = :name").setParameter("name", "ModelingPD_BAI_dtForbearance").uniqueResult())
entity.datasets.add(session.createQuery("from sse.Dataset where name = :name").setParameter("name", "ModelingPD_BAI_dtPDModel").uniqueResult())
entity.paragraphs.find {it.name == "ModelingPD_BAI_Modelling_2019-03-11T11:44:24.149"}.body.linkNotebook = session.createQuery("from sse.Notebook where name = :name").setParameter("name", "ModelingPD_BAI_FunctionLibrary").uniqueResult()
Context.current.commit()
