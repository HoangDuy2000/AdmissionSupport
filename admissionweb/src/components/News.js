import { Button, Card, Col, Nav, Row, Spinner } from "react-bootstrap";
import { Link, useSearchParams } from "react-router-dom";
import Apis, { endpoint } from "../configs/Apis";
import { useEffect, useState } from "react";

const News = () => {
    const [news, setNews] = useState(null);
    const[q] = useSearchParams();

    useEffect(() => {
        const loadNews = async () => {
            try{
                let e = endpoint['news'];

                let kw = q.get("kw");
                if(kw !== null && kw !== ""){
                    e = `${e}?kw=${kw}`
                }

                let res = await Apis.get(e);
                setNews(res.data)
            }catch (ex){
                console.error(ex)
            }
        }
        
        loadNews();

    }, [q]);

    if (news === null)
        return <Spinner animation="border" variant="primary" />;

    return (
        <Nav>
            <Row>
                {news.map(n => {
                    return <Col xs={6} md={4}>
                        <div class="mt-4">
                            <Card>
                            <Card.Body style={{ height: '270px'}}>
                                <Card.Title class="text-center text-uppercase" style={{height: '70px'}}><strong><Link class={"text-decoration-none"}>{n.title}</Link></strong></Card.Title>
                                <h5>
                                    <span href="#" class="badge bg-secondary">{n.typesId.name}</span>
                                    <span href="#" class="badge bg-secondary">{n.facultysId.name}</span>
                                </h5>
                                <Card.Text class={"overflow-hidden"} style={{ height: '75px' }}>
                                    {n.content}
                                </Card.Text>
                                <Button variant="primary">Đọc Tin</Button>
                            </Card.Body>
                            </Card>
                        </div>
                    </Col>
                })}
            </Row>
        </Nav>
    )
}

export default News;
