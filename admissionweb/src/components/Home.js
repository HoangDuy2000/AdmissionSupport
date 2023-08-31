import { useEffect, useState } from "react";
import Apis, { endpoint } from "../configs/Apis";
import { Button, Card, Carousel, Col, Nav, Row, Spinner } from "react-bootstrap";
import { Link } from "react-router-dom";

const Home = () => {
    const [news, setNews] = useState(null);

    useEffect(() => {
        const loadNews = async () => {
            try{
                let res = await Apis.get(endpoint['news']);
                setNews(res.data)
            }catch (ex){
                console.error(ex)
            }
        }
        
        loadNews();

    }, []);

    if (news === null)
        return <Spinner animation="border" variant="primary" />;

    return <>
        <Nav>
            <Carousel>
                <Carousel.Item>
                    <img
                    className="d-block w-100"
                    src="https://marketplace.canva.com/EAFdxUjQ2Ps/1/0/1600w/canva-orange-decorative-welcome-back-to-school-banner-ea9k3VDJ7pY.jpg"
                    alt="First slide"
                    />
                    <Carousel.Caption>
                    <h5>First slide label</h5>
                    <p>Nulla vitae elit libero, a pharetra augue mollis interdum.</p>
                    </Carousel.Caption>
                </Carousel.Item>
                <Carousel.Item>
                    <img
                    className="d-block w-100"
                    src="https://marketplace.canva.com/EAFdxUjQ2Ps/1/0/1600w/canva-orange-decorative-welcome-back-to-school-banner-ea9k3VDJ7pY.jpg"
                    alt="Second slide"
                    />
                    <Carousel.Caption>
                    <h5>Second slide label</h5>
                    <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.</p>
                    </Carousel.Caption>
                </Carousel.Item>
                <Carousel.Item>
                    <img
                    className="d-block w-100"
                    src="https://marketplace.canva.com/EAFdxUjQ2Ps/1/0/1600w/canva-orange-decorative-welcome-back-to-school-banner-ea9k3VDJ7pY.jpg"
                    alt="Third slide"
                    />
                    <Carousel.Caption>
                    <h5>Third slide label</h5>
                    <p>
                        Praesent commodo cursus magna, vel scelerisque nisl consectetur.
                    </p>
                    </Carousel.Caption>
                </Carousel.Item>
            </Carousel>
            <div class="mt-4">
                <Row>
                    {news.map(n => {
                        return <Col xs={4}>
                            <Card class="">
                            <Card.Body style={{ height: '270px' }}>
                                <Card.Title class="text-center text-uppercase" style={{height: '70px'}}><strong><Link class={"text-decoration-none"}>{n.title}</Link></strong></Card.Title>
                                <h5>
                                    <span href="#" class="badge bg-secondary ">{n.typesId.name}</span>
                                    <span href="#" class="badge bg-secondary">{n.facultysId.name}</span>
                                </h5>
                                <Card.Text class={"overflow-hidden"} style={{ height: '75px' }}>
                                    {n.content}
                                </Card.Text>
                                <Button variant="primary">Đọc Tin</Button>
                            </Card.Body>
                            </Card>
                        </Col>
                    })}
                </Row>
            </div>
        </Nav>
    </>
}

export default Home;