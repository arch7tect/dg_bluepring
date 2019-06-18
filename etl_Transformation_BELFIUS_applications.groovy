import ru.neoflex.meta.utils.Context
def session = Context.current.txSession
def entity = session.createQuery("from etl.Transformation where name = :name").setParameter("name", "BELFIUS_applications").uniqueResult() 
entity.userDefinedFunctions.clear()
entity.project = session.createQuery("from etl.Project where name = :name").setParameter("name", "blueprint_git").uniqueResult()
entity.targets.find {it.name == "CSV_FUSION_RISK"}.context = null
entity.targets.find {it.name == "DS_XML_RESP"}.context = null
entity.sources.find {it.name == "DS_XML_REQ"}.context = null
entity.sources.find {it.name == "PRODUCT_CATALOG"}.context = null
Context.current.commit()
